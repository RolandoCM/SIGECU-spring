package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlumnoEventosId is a Querydsl query type for AlumnoEventosId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAlumnoEventosId extends BeanPath<AlumnoEventosId> {

    private static final long serialVersionUID = -967108347L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlumnoEventosId alumnoEventosId = new QAlumnoEventosId("alumnoEventosId");

    public final QAlumno alumno;

    public final QEventos eventos;

    public QAlumnoEventosId(String variable) {
        this(AlumnoEventosId.class, forVariable(variable), INITS);
    }

    public QAlumnoEventosId(Path<? extends AlumnoEventosId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlumnoEventosId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlumnoEventosId(PathMetadata metadata, PathInits inits) {
        this(AlumnoEventosId.class, metadata, inits);
    }

    public QAlumnoEventosId(Class<? extends AlumnoEventosId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alumno = inits.isInitialized("alumno") ? new QAlumno(forProperty("alumno"), inits.get("alumno")) : null;
        this.eventos = inits.isInitialized("eventos") ? new QEventos(forProperty("eventos"), inits.get("eventos")) : null;
    }

}

