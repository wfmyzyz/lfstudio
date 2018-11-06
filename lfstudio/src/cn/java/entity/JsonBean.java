package cn.java.entity;

public class JsonBean {
	private Integer aboutid;
	private double abouthygiene;
	
	public Integer getAboutid() {
		return aboutid;
	}
	public void setAboutid(Integer aboutid) {
		this.aboutid = aboutid;
	}
	public double getAbouthygiene() {
		return abouthygiene;
	}
	public void setAbouthygiene(double abouthygiene) {
		this.abouthygiene = abouthygiene;
	}
	public JsonBean(Integer aboutid, Float abouthygiene) {
		super();
		this.aboutid = aboutid;
		this.abouthygiene = abouthygiene;
	}
	public JsonBean() {
		
	}
	@Override
	public String toString() {
		return "JsonBean [aboutid=" + aboutid + ", abouthygiene=" + abouthygiene + "]";
	}
	
}
