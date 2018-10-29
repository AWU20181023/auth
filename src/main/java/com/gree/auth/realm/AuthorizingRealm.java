package com.gree.auth.realm;

/**
 * Created by 260152(AWU) on 2018/10/27 19:41.
 */
public abstract class AuthorizingRealm {
    protected abstract Boolean doGetAuthorization(String[] perms);
}
