package com.arara.contabil.controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arara.contabil.dto.ViewOrganizationFileDto;
import com.arara.contabil.service.ExportExcelFileService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ExportExcelFileController {

	@Autowired
	private ExportExcelFileService exportExcelFileService;

	@GetMapping("/organizations/{organization_id}/files/view-exported-files")
	public String showExportedFiles(@PathVariable("organization_id") Long organizationId,
			@RequestParam(required = false) String filename, Model model) {

		List<ViewOrganizationFileDto> files = new ArrayList<>();
		if (filename != null) {
			var newFile = new ViewOrganizationFileDto();
			newFile.setOrganizationId(organizationId);
			newFile.setFilename(filename);
			newFile.setFiletype("xlsx");
			newFile.setPurpose("test");
			newFile.setIsAvailable(true);
			newFile.setDownloadLink("/organizations/" + organizationId + "/files/download/" + filename);
			newFile.setCreatedAt(Instant.now());
			newFile.setCreatedBy(1l);
			files.add(newFile);
		}
		model.addAttribute("files", files);
		return "view-exported-files";
	}

	@GetMapping("/organizations/{organization_id}/files/generate-excel-file")
	public String generateExcelFile(@PathVariable("organization_id") Long organizationId,
			RedirectAttributes redirectAttributes) {

		String filename = exportExcelFileService.generateXlsxFile();

		redirectAttributes.addAttribute("filename", filename);

		return "redirect:/organizations/{organization_id}/files/view-exported-files";
	}


	@GetMapping(value = "/organizations/{organization_id}/files/download/{filename}", produces = "application/vnd.ms-excel.sheet.macroEnabled.12")
	@ResponseBody
	public FileSystemResource downloadfile( //
			@PathVariable("organization_id") Long organizationId, //
			@PathVariable("filename") String filename, //
			HttpServletResponse response) throws IOException {

		String safeFilename = filename.replace("/", "");
		File currDir = new File("files/");
		File currFile = new File(currDir, safeFilename);

		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + safeFilename);

		return new FileSystemResource(currFile);
	}
}
