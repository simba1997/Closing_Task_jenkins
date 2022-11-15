package com.example.fursa_closing_jenkins_task;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*import javax.sql.rowset.spi.XmlReader;*/
import javax.xml.stream.events.DTD;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@RestController
public class XMLtoHTMLController {

        @RequestMapping
        public  ModelAndView getData(Model titlemodel,Model linkmodel){
            List lst = new ArrayList();
            String link ="http://www.ynet.co.il/Integration/StoryRss2.xml";

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("html_table_handler.html");
            try {
                URL url = new URL(link);
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(url));
                lst = feed.getEntries();
                titlemodel.addAttribute("ynetNews",lst);
            } catch (IOException | FeedException e) {
                e.printStackTrace();
            }
                return modelAndView;
            }

        }


