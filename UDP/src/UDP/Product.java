package UDP;  

import java.io.Serializable;  

/**  
 *  
 * @author Phu Laptop  
 */  
public class Product implements Serializable {  
    private static final long serialVersionUID = 20161107L; // Thêm serialVersionUID  
    private String id, code, name;  
    private int quatity;  

    public Product(String id, String code, String name, int quatity) {  
        this.id = id;  
        this.code = code;  
        this.name = name;  
        this.quatity = quatity;  
    }  

    public String getId() {  
        return id;  
    }  

    public void setId(String id) {  
        this.id = id;  
    }  

    public String getCode() {  
        return code;  
    }  

    public void setCode(String code) {  
        this.code = code;  
    }  

    public String getName() {  
        return name;  
    }  

    public void setName(String name) {  
        this.name = name;  
    }  

    public int getQuatity() {  
        return quatity;  
    }  

    public void setQuatity(int quatity) {  
        this.quatity = quatity;  
    }  

    @Override  
    public String toString() {  
        return "Product{" + "id=" + id + ", code=" + code + ", name=" + name + ", quatity=" + quatity + '}';  
    }  
}