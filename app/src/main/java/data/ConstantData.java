package data;

import java.util.ArrayList;

import bean.Setting;

public class ConstantData {
    public static final ArrayList<Setting> SETTING_LIST_LOGIN = new ArrayList<Setting>() {
        {
            add(new Setting(true, false, false, "ÐÞ¸ÄÃÜÂë", true, false, "", true));
            add(new Setting(false, false, false, "Çå³ý»º´æ", false, false, "", true));
            add(new Setting(false, true, false, "¼ì²é¸üÐÂ", false, true, "", true));
            add(new Setting(true, false, false, "°ïÖú", true, false, "", true));
            add(new Setting(false, false, false, "¹ØÓÚ", false, false, "", true));
            add(new Setting(false, true, false, "Ê¹ÓÃÐ­Òé", false, true, "", true));
            add(new Setting(false, false, true, "ÍË³öµÇÂ¼", false, false, "", true));
        }
    };
}
