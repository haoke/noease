/**
*这是个上传文件代码
*
*/
@Controller
public class FileUpload {

    @RequestMapping(path="/upload.do",method = RequestMethod.POST)
    public String upload(MultipartFile mfile, HttpServletRequest req) throws IOException {

        String  path = req.getServletContext().getRealPath("/uploadDir");
        System.out.println(path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        String originalFilename = mfile.getOriginalFilename();
        mfile.transferTo(new File(path, originalFilename));
        return "success";
    }


    @RequestMapping(path="remoteUpdate.do", method = RequestMapping.POST)
    public String remoteUpdate(MultipartFile mfile) throws IOException {
        String path = "http://localhost:9090/fileserver/uploads";
        String originalFilename = mfile.getOriginalFilename();

        Client client= new Client();
        WebResource resource = client.resource(path+ originalFilename);
        resource.put(mfile.getBytes());

        return "success";

    }
}
