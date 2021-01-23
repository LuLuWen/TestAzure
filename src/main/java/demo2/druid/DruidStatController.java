package demo2.druid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

@RestController
public class DruidStatController {

    @GetMapping("/druidStat")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 該方法可以獲取所有資料來源的監控資料
        // 除此之外 DruidStatManagerFacade 還提供了一些其他方法，我們可以按需選擇使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
    
}
