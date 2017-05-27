package quyntg94.techkids.vn.demoretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by quyntg94 on 23/05/2017.
 */

public interface RegisterService {
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);
}
