package bean;

public class Association {
    public Association() {

    }

    public Association(String name, int id, float fee, int number, int level, int status) {
        this.name = name;
        this.id = id;
        this.fee = fee;
        this.number = number;
        this.level = level;
        this.status = status;
    }

    private int db_id;      //数据库中自增的id，在DAO的增删改查中没用到（用的都是社团id
    private String name;        //社团名称
    private int id;  //社团id

    private  float fee ;       //社团费用用
    private  int number;        //社团人数

    private  int level;         //社团等级

    private int status;        //是否删除

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
