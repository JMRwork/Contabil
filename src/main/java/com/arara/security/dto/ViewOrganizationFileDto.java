package com.arara.security.dto;

import java.time.Instant;

public class ViewOrganizationFileDto {

	private Long organizationId;
	private String filename;
	private String filetype;
	private String purpose;
	private Boolean isAvailable;
	private String downloadLink;
	private Long createdBy;
	private Long lastModifiedBy;
	private Instant createdAt;
	private Instant lastModifiedAt;
	private Instant deletedAt;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organization_id) {
		this.organizationId = organization_id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Instant lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		return "ViewOrganizationFileDto [organization_id=" + organizationId + ", filename=" + filename + ", filetype="
				+ filetype + ", purpose=" + purpose + ", isAvailable=" + isAvailable + ", downloadLink=" + downloadLink
				+ ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdAt=" + createdAt
				+ ", lastModifiedAt=" + lastModifiedAt + ", deletedAt=" + deletedAt + "]";
	}

}
