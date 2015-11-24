package kkdev.kksystem.kkcarandroid.wmhttp;

import java.io.BufferedReader;
import java.io.IOException;

import kkdev.kksystem.kkcarandroid.manager.types.ConfigurationInfo;

/**
 * Created by blinov_is on 24.11.2015.
 */
public class WebManager {

    final static String ___TEST_KKCAR_UUID_ = "2e2efd7b-ab83-42fa-9c00-2e45bb4b3ba1";
    final static String WEBMASTER_URL = "http://localhost/";
    final static String WEBMASTER_URL_SERVICE = "kkcontroller/request";


    public ConfigurationInfo GetMyConfInfo()
    {
        /*
        try {
            HttpClient   client = create().build();
            HttpPost post = new HttpPost(WEBMASTER_URL + WEBMASTER_URL_SERVICE);

            post.setEntity(new UrlEncodedFormEntity(GetConfigurationDataRequest()));

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            Ans
                    = gson.fromJson(rd, WM_Answer.class
            );

            if (Ans.AnswerState
                    == 0) {
                WMAnswer RC = gson.fromJson(Ans.JsonData, WMAnswer.class);
                return RC;
            } else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        return null;
    }


}
