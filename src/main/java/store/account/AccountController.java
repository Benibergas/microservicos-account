package store.account;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "account", url = "http://account:8080")
public interface AccountController {

    @PostMapping("/account")
    public ResponseEntity<ProductOut> create(
        @RequestBody ProductIn accountIn
    );

    @GetMapping("/account")
    public ResponseEntity<List<ProductOut>> findAll();

    @PostMapping("/account/login")
    public ResponseEntity<ProductOut> findByEmailAndPassword(
        @RequestBody ProductIn accountIn
    );

    @GetMapping("/account/whoami")
    public ResponseEntity<ProductOut> whoami(
        @RequestHeader(value = "id-account", required = true) String idAccount
    );

}