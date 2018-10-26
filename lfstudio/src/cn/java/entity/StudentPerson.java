package cn.java.entity;

import java.util.Date;

public class StudentPerson {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.id
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.studentid
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private String studentid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.name
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.sex
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private Byte sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.birthday
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.birthpath
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private String birthpath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.homepath
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private String homepath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.nation
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private String nation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.headimg
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private String headimg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.dormitory
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private int dormitory;
    
    private int room;
    public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public void setDormitory(int dormitory) {
		this.dormitory = dormitory;
	}

	public int getDormitory() {
		return dormitory;
	}

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.college
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private Integer college;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.major
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private Integer major;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student_person.majorclass
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    private Integer majorclass;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.id
     *
     * @return the value of student_person.id
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.id
     *
     * @param id the value for student_person.id
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.studentid
     *
     * @return the value of student_person.studentid
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.studentid
     *
     * @param studentid the value for student_person.studentid
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.name
     *
     * @return the value of student_person.name
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.name
     *
     * @param name the value for student_person.name
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.sex
     *
     * @return the value of student_person.sex
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.sex
     *
     * @param sex the value for student_person.sex
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.birthday
     *
     * @return the value of student_person.birthday
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.birthday
     *
     * @param birthday the value for student_person.birthday
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.birthpath
     *
     * @return the value of student_person.birthpath
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public String getBirthpath() {
        return birthpath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.birthpath
     *
     * @param birthpath the value for student_person.birthpath
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setBirthpath(String birthpath) {
        this.birthpath = birthpath == null ? null : birthpath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.homepath
     *
     * @return the value of student_person.homepath
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public String getHomepath() {
        return homepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.homepath
     *
     * @param homepath the value for student_person.homepath
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setHomepath(String homepath) {
        this.homepath = homepath == null ? null : homepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.nation
     *
     * @return the value of student_person.nation
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public String getNation() {
        return nation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.nation
     *
     * @param nation the value for student_person.nation
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.headimg
     *
     * @return the value of student_person.headimg
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.headimg
     *
     * @param headimg the value for student_person.headimg
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.college
     *
     * @return the value of student_person.college
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public Integer getCollege() {
        return college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.college
     *
     * @param college the value for student_person.college
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setCollege(Integer college) {
        this.college = college;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.major
     *
     * @return the value of student_person.major
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public Integer getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.major
     *
     * @param major the value for student_person.major
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setMajor(Integer major) {
        this.major = major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student_person.majorclass
     *
     * @return the value of student_person.majorclass
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public Integer getMajorclass() {
        return majorclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student_person.majorclass
     *
     * @param majorclass the value for student_person.majorclass
     *
     * @mbg.generated Mon Oct 22 14:42:59 CST 2018
     */
    public void setMajorclass(Integer majorclass) {
        this.majorclass = majorclass;
    }

	@Override
	public String toString() {
		return "StudentPerson [id=" + id + ", studentid=" + studentid + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", birthpath=" + birthpath + ", homepath=" + homepath + ", nation="
				+ nation + ", headimg=" + headimg + ", dormitory=" + dormitory + ", college=" + college + ", major="
				+ major + ", majorclass=" + majorclass + "]";
	}
    
}