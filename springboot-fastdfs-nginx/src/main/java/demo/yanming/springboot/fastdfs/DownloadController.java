package demo.yanming.springboot.fastdfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.yanming.springboot.starter.fastdfs.service.FastdfsClientService;

@Controller
@RequestMapping(value = "/download")
public class DownloadController {

    @Autowired
    private FastdfsClientService service;

    @ResponseBody
    @RequestMapping(value = "/image")
    public String image() throws Exception {
        // 之前上传过的数据，实际应用场景应该使用SQL数据库来存储
        return service.autoDownloadWithToken("group1", "M00/00/00/wKhQA1ysjSGAPjXbAAVFOL7FJU4.tar.gz", "192.168.80.1");
    }
}
	