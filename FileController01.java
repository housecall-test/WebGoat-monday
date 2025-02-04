package io.mend.remediation.mendjavavul.cwe22;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController01 {

  private final String BASE_DIRECTORY = "./src/test/resources/testfiles";

  @PostMapping("/deleteFile1")
  public ResponseEntity<String> deleteFile(HttpServletRequest request) {
    String filename = request.getParameter("filename");
    try {
      File dictionaryFile = new File(BASE_DIRECTORY, filename);
      boolean success = dictionaryFile.delete();
      if (!success) {
        return ResponseEntity.badRequest().body("Error: could not delete file.");
      }
    } catch (Exception ex) {
      return ResponseEntity.badRequest().body("Error: could not delete file.");
    }
    return ResponseEntity.ok("");
  }
}
