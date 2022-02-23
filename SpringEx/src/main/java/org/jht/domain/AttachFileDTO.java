package org.jht.domain;

public class AttachFileDTO {
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	private int bno;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() { // 잘 만들어지는지 확인용 엄청 필요하거나 그런건 아님
		return "AttachFileDTO [fileName=" + fileName + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", image="
				+ image + ", bno=" + bno + "]";
	}
	
	


}
