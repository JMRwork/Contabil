package com.arara.contabil.controller;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arara.contabil.dto.ViewOrganizationFileDto;
import com.arara.contabil.service.ExportExcelFileService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/organizations/{organization_id}/files")
public class ExportExcelFileController {

	@Autowired
	private ExportExcelFileService exportExcelFileService;

	@GetMapping("/view-exported-files")
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

	@GetMapping("/generate-excel-file")
	public String generateExcelFile(@PathVariable("organization_id") Long organizationId,
			RedirectAttributes redirectAttributes) {

		String filename = exportExcelFileService.generateXlsxFile(organizationId);

		redirectAttributes.addAttribute("filename", filename);

		return "redirect:/organizations/{organization_id}/files/view-exported-files";
	}


	@GetMapping(value = "/download/{filename}", produces = "application/vnd.ms-excel.sheet.macroEnabled.12")
	@ResponseBody
	public FileSystemResource downloadfile( //
			@PathVariable("organization_id") Long organizationId, //
			@PathVariable("filename") String filename, //
			HttpServletResponse response) throws IOException {
		
		String safeFilename = exportExcelFileService.sanitizeFilenameString(filename);
		File currDir = new File(exportExcelFileService.getDirRelativePath(organizationId));
		File currFile = new File(currDir, safeFilename);

		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= " + safeFilename);

		return new FileSystemResource(currFile);
	}
	
	@GetMapping(value = "/delete/{filename}")
	public String deleteFile( //
			@PathVariable("organization_id") Long organizationId, //
			@PathVariable("filename") String filename) throws IOException {

		String safeFilename = exportExcelFileService.sanitizeFilenameString(filename);
		File currDir = new File(exportExcelFileService.getDirRelativePath(organizationId));
		File currFile = new File(currDir, safeFilename);

		if(currFile.exists()) {
			currFile.delete();
		}

		return "redirect:/organizations/{organization_id}/files/view-exported-files";
	}
	

	
}
