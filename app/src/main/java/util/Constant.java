package util;


/**
 * Created by adityamathur on 12/03/15.
 */
public class Constant {



    public static String DATABASE_NAME = "CityLocality";

    static String domain="https://dev.99laundry.com/";
    static String oldDomain="http://laundry.rhcdev.in/";

    public static String CREATE_ACCOUNT = domain+"api/accounts/create";
    public static String GET_CITY_AREA = domain+"api/area/masterarea";
    public static String LOGIN_POST = domain+"token";
    public static String GET_USERPROFILE = domain+"api/accounts/UserProfile";
    public static String UPDATE_PROFILE = domain+"api/accounts/UpdateProfile";
    public static String FORGOT_PASSWORD = domain+"api/accounts/ForgotPassword";
    public static String CHANGE_PASSWORD = domain+"api/accounts/ChangePassword";
    public static String VERIFYNUMBER = domain+"accounts/VerifyNumber";
    public static String USERADDRESS = domain+"api/accounts/UserAddress";
    public static String CREATEADDRESS = domain+"api/accounts/CreateAddress";
    public static String DELETEADDRESS = domain+"api/accounts/DeleteAddress";
    public static String UPDATEADDRESS = domain+"api/accounts/UpdateAddress";
    public static String VERIFYNEWNO = domain+"api/accounts/VerifyNewNumber";
    public static String VENDERLIST = domain+"api/Service/VendorService/";
    public static String ALLSERVICES = domain+"api/Service/AllService";
    public static String ITEMSERVICE = domain+"api/Service/AllServiceCat";
    public static String VENDERGALLERY = domain+"api/Service/GetVImages?id=";
    public static String PLACEORDER = domain+"api/accounts/PlaceOrder";
    public static String GETORDER = domain+"api/accounts/GetUserOrders";
    public static String CHANGENO = domain+"api/accounts/UpdateNewNumber";
    public static String GETTIMESLOT = domain+"api/Service/TimeSlots";
    public static String GETDISCOUNT = domain+"api/Service/VendorDiscount?VendorId=";
    public static String PAYMENTSTATUS = domain+"api/accounts/PlaceOrderAfterPayment";
    public static String UPLOADIMAGE = domain+"api/accounts/UploadImage";
    public static String CANCELORDER = domain+"api/accounts/OrderCancel";
    public static String VENDORDETAIL = domain+"api/Service/VendorById/";

    public static String MYFAVVEDORS = domain+"api/accounts/VendorUsed";
    public static String RATING = domain+"api/accounts/WriteReview";
    public static String ADDREMOVEFAV = domain+"api/accounts/RemoveFav/";

    public static String CHECKPAYMENTGETWAYSTATUS = domain+"api/accounts/PaymentStatus";
    public static String ADMINDIXCOUNT = domain+"api/Service/AdminDiscount";
    public static String GETORDERDETAIL = domain+"api/accounts/GetUserOrderDetails/";
    public static String FEEDBACK = domain+"api/accounts/Feedback";
    public static String LAUNDRYINFO = domain+"api/Service/LaundryInfo";


//https://dev.99laundry.com/Account/MyVendors


    //
    //sw3 details
    public static String accessKey = "AKIAJPGDNYPSDHFXHVKA";
    public static String secretKey = "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";
    public static String bucketname = "laundryimages";

    //youtube video

    public static String DEVELOPERKEY = "AIzaSyDDcukIKxJdlZw0-4h2HGfzh52ZCE4ELo0";

}

