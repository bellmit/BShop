package cniao5.com.admin.bean;

/**
 * 轮播广告属性
 * Created by Administration on 15/10/2.
 */
public class Banner extends BaseBean {

    private  String name;
    private  String imgUrl;
    private  String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
