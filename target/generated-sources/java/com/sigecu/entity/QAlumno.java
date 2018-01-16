package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlumno is a Querydsl query type for Alumno
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlumno extends EntityPathBase<Alumno> {

    private static final long serialVersionUID = -1341603564L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlumno alumno = new QAlumno("alumno");

    public final StringPath aCarrera = createString("aCarrera");

    public final StringPath aEmail = createString("aEmail");

    public final SetPath<Alumno_Has_Eventos, QAlumno_Has_Eventos> alumnoHasEventos = this.<Alumno_Has_Eventos, QAlumno_Has_Eventos>createSet("alumnoHasEventos", Alumno_Has_Eventos.class, QAlumno_Has_Eventos.class, PathInits.DIRECT2);

    public final StringPath aMaterno = createString("aMaterno");

    public final StringPath aNombre = createString("aNombre");

    public final StringPath aNotebook = createString("aNotebook");

    public final StringPath aPaterno = createString("aPaterno");

    public final StringPath aStatus = createString("aStatus");

    public final StringPath aTelefono = createString("aTelefono");

    public final NumberPath<Integer> idAlumno = createNumber("idAlumno", Integer.class);

    public final QUsers user;

    public QAlumno(String variable) {
        this(Alumno.class, forVariable(variable), INITS);
    }

    public QAlumno(Path<? extends Alumno> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlumno(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlumno(PathMetadata metadata, PathInits inits) {
        this(Alumno.class, metadata, inits);
    }

    public QAlumno(Class<? extends Alumno> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

