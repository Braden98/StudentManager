package bean;

import java.util.Date;

/**
 * 学生 POJO
 */
public class  Student {

	private int id;				// 在数据库中的ID,dao层中做了修改，使得查找操作使用的是学号而不是数据库id
	//另外，关于DB中自增，在DAO中insert不处理id，让数据库自动完成。
	private int studentID;      // 学号，跟ID区分开为了方便数据库操作
	private String name;		// 姓名
	private int age;			// 年龄
	private String sex;			// 性别
	private int assID;			//社团id，新增
	private Date birthday;		// 出生日期

	public int getAssID() {
		return assID;
	}

	public void setAssID(int assID) {
		this.assID = assID;
	}



	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int student_id) {
		this.studentID  = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
