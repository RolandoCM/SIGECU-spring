package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = 945217528L;

    public static final QUsers users = new QUsers("users");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath imagen = createString("imagen");

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public final SetPath<UserRole, QUserRole> userRole = this.<UserRole, QUserRole>createSet("userRole", UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

