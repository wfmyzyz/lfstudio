package cn.java.entity;

public class SchoolCollege {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_college.id
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_college.collegename
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_college.pid
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    private Integer pid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_college.id
     *
     * @return the value of school_college.id
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    
    private SchoolMajor schoolMajor;
    


	public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_college.id
     *
     * @param id the value for school_college.id
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_college.pid
     *
     * @return the value of school_college.pid
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_college.pid
     *
     * @param pid the value for school_college.pid
     *
     * @mbg.generated Wed Oct 17 09:42:35 CST 2018
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

	public SchoolMajor getSchoolMajor() {
		return schoolMajor;
	}

	public void setSchoolMajor(SchoolMajor schoolMajor) {
		this.schoolMajor = schoolMajor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SchoolCollege [id=" + id + ", name=" + name + ", pid=" + pid + ", schoolMajor=" + schoolMajor + "]";
	}


    
}