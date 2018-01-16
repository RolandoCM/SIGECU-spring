package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInstructor is a Querydsl query type for Instructor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInstructor extends EntityPathBase<Instructor> {

    private static final long serialVersionUID = -2121370451L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInstructor instructor = new QInstructor("instructor");

    public final StringPath carrera = createString("carrera");

    public final NumberPath<Integer> idInstructor = createNumber("idInstructor", Integer.class);

    public final StringPath iDireccion = createString("iDireccion");

    public final StringPath iEmail = createString("iEmail");

    public final StringPath iMaterno = createString("iMaterno");

    public final StringPath iNombre = createString("iNombre");

    public final StringPath iPaterno = createString("iPaterno");

    public final StringPath iTelefono = createString("iTelefono");

    public final QUsers user;

    public QInstructor(String variable) {
        this(Instructor.class, forVariable(variable), INITS);
    }

    public QInstructor(Path<? extends Instructor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInstructor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInstructor(PathMetadata metadata, PathInits inits) {
        this(Instructor.class, metadata, inits);
    }

    public QInstructor(Class<? extends Instructor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

