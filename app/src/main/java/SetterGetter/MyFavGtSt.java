package SetterGetter;

/**
 * Created by shailb on 04/05/16.
 */
public class MyFavGtSt {

    String $id;
    int vendorid;


    String VendorShopName;
    boolean IsFav;
    String ShopAddress;
    String ImagePath;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public int getVendorid() {
        return vendorid;
    }

    public void setVendorid(int vendorid) {
        this.vendorid = vendorid;
    }

    public String getVendorShopName() {
        return VendorShopName;
    }

    public void setVendorShopName(String vendorShopName) {
        VendorShopName = vendorShopName;
    }

    public String getShopAddress() {
        return ShopAddress;
    }

    public void setShopAddress(String shopAddress) {
        ShopAddress = shopAddress;
    }

    public boolean isFav() {
        return IsFav;
    }

    public void setIsFav(boolean isFav) {
        IsFav = isFav;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }


}
