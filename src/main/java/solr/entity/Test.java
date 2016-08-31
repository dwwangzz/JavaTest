package solr.entity;

import org.apache.solr.client.solrj.beans.Field;

public class Test {
	@Field
    private String id;
    @Field
    private String title;
    @Field
    private String content;
    @Field
    private String peopleName;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
}
