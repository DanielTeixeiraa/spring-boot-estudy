package com.daniel.teste.error;


public class ResourceNotFoundDetails {
	private String title;
	private int status;
	private String detail;
	private long timestamp;
	private String developerMessage;

	
	private ResourceNotFoundDetails(Buildes builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.detail = builder.detail;
		this.timestamp = builder.timestamp;
		this.developerMessage = builder.developerMessage;
	}
	
	private ResourceNotFoundDetails() {
	}
	
	
	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetail() {
		return detail;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}


	public static Buildes builder() {
		return new Buildes();
	}

	public static final class Buildes {
		private String title;
		private int status;
		private String detail;
		private long timestamp;
		private String developerMessage;

		private Buildes() {
		}

		public Buildes withTitle(String title) {
			this.title = title;
			return this;
		}

		public Buildes withStatus(int status) {
			this.status = status;
			return this;
		}

		public Buildes withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public Buildes withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Buildes withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourceNotFoundDetails build() {
			return new ResourceNotFoundDetails(this);
		}
	}
	
}
