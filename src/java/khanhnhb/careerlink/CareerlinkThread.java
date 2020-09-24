package khanhnhb.careerlink;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import static khanhnhb.common.AppConstant.BEAUTY_GARDEN_URL;
import khanhnhb.common.BaseThread;
import khanhnhb.entities.Vendor;

/**
 *
 * @author Hello
 */
public class CareerlinkThread extends BaseThread implements Runnable {

    private ServletContext context;

    public CareerlinkThread(ServletContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        BeautyGardenCategoriesCrawlers beautyGardenCrawler = new BeautyGardenCategoriesCrawlers(context);
        Map<String, String> categories = beautyGardenCrawler.getCatalogsAndCategories(BEAUTY_GARDEN_URL);

        Vendor vendor = beautyGardenCrawler.getVendor(BEAUTY_GARDEN_URL);
        try {
            if (categories != null) {

                for (Map.Entry<String, String> entry : categories.entrySet()) {
                    Thread crawlingThread = new Thread(new BeautyGardenCatergoryCrawler(context, entry.getKey(), entry.getValue(), vendor));
                    crawlingThread.start();

                    synchronized (BaseThread.getInstance()) {
                        while (BaseThread.isSuspended()) {
                            BaseThread.getInstance().wait();
                        }
                    }
                } // End for each Category
            }
            CareerlinkThread.sleep(TimeUnit.DAYS.toMillis(2000));
            synchronized (BaseThread.getInstance()) {
                while (BaseThread.isSuspended()) {
                    BaseThread.getInstance().wait();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CareerlinkThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
