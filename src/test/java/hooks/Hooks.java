package hooks;

import io.cucumber.java.Before;

import static base_urls.MedunnaBaseUrl.setUp;

public class Hooks {

    @Before("@api") //Bu method sadece @api tagine sahip scenariolardan önce çalışır. Parantez içi boş bırakılırsa tüm
                    //proje içindeki scenariolardan önce çalışır.
    public void beforeApi (){

        setUp();
    }

}
