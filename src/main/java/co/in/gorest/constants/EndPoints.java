package co.in.gorest.constants;


public class EndPoints {

    /**
     * This is Endpoints of student api
     */
    public static final String GET_ALL_USERS = "/users";
    public static final String GET_SINGLE_USERS_BY_ID = "/{user_id}";
    public static final String UPDATE_USERS_BY_ID = "/{user_id}";
    public static final String DELETE_USERS_BY_ID = "/{user_id}";

    public static final String AUTH = "/my-account/access-tokens";

    /**
     * This is Endpoints of Authentication api
     */
    public static final String GET_ALL_USER="/users";
    public static final String CREATE_USERS="/users";
    public static final String UPDATE_USER_BY_ID="/users/{id}";
    public static final String GET_USER_BY_ID="/users/{id}";
    public static final String DELETE_USER_BY_ID="/users/{id}";


}
