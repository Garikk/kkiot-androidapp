/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import kkdev.kksystem.base.constants.SystemConsts;

/**
 *
 * @author blinov_is
 */
public class SettingsManager {

    String ConfigurationFile;
    Type SettingsClassType;

    public SettingsManager(String FileName, Type SettingsClass) {
        SettingsClassType = SettingsClass;
        ConfigurationFile = FileName;
    }

    public void SaveConfig(Object Configuration) {
        try {
            Gson gson = new Gson();

            String Res = gson.toJson(Configuration);

            FileWriter fw;
            fw = new FileWriter(SystemConsts.KK_BASE_CONFPATH + "/" + ConfigurationFile);
            fw.write(Res);
            fw.flush();
            fw.close();

        } catch (IOException ex) {
            //  Logger.getLogger(kk_DefaultConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object LoadConfig() {
        Object Ret;
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(
                    new FileReader(SystemConsts.KK_BASE_CONFPATH + "/" + ConfigurationFile));
            //
            Ret = gson.fromJson(br, SettingsClassType);
            //
            br.close();
            //
            return Ret;
        } catch (FileNotFoundException  ex ) {
            return null;
        }
          catch (IOException  ex ) {
              return null;
        }

    }

}
