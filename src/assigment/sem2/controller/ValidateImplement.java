package assigment.sem2.controller;

public class ValidateImplement implements Validate {
    private static final String ID_PATTERN = "Order\\d{3,5}";
    private static final String CUSTOMER_PATTERN =
            "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
                    "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
                    "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";
    public static final String DATE_PATTERN = "\t\n" + "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    public static final String PRICE_PATTERN = "\t\n" + "[^A-Za-z0-9]+";
    public static final String PRODUCTS_PATTERN = "\t\n" + "[^A-Z]";

    @Override
    public boolean verifyId(String id) {
        if (id == null) return false;
        return id.matches(ID_PATTERN);
    }

    @Override
    public boolean verifyCustomer(String customer) {
        if (customer == null) return false;
        return customer.matches(CUSTOMER_PATTERN);
    }

    @Override
    public boolean verifyProducts(String products) {
        if (products == null) return false;
        return products.matches(CUSTOMER_PATTERN);
    }

    @Override
    public boolean verifyDate(String strDate) {
        if (strDate == null) return false;
        return strDate.matches(DATE_PATTERN);
    }

    @Override
    public boolean verifyPrice(int price) {
        return false;
    }

    @Override
    public boolean verifyStatus(int status) {
        if (status != 1 && status !=0 && status !=2) return false;
        return true;
    }
}
