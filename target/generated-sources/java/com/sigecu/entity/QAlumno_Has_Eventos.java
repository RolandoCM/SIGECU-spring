package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlumno_Has_Eventos is a Querydsl query type for Alumno_Has_Eventos
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlumno_Has_Eventos extends EntityPathBase<Alumno_Has_Eventos> {

    private static final long serialVersionUID = -776428946L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlumno_Has_Eventos alumno_Has_Eventos = new QAlumno_Has_Eventos("alumno_Has_Eventos");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final QAsignaExamenEntity asignaExamen;

    public final StringPath confirmado = createString("confirmado");

    public final QAlumnoEventosId primaryKey;

    public QAlumno_Has_Eventos(String variable) {
        this(Alumno_Has_Eventos.class, forVariable(variable), INITS);
    }

    public QAlumno_Has_Eventos(Path<? extends Alumno_Has_Eventos> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlumno_Has_Eventos(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlumno_Has_Eventos(PathMetadata metadata, PathInits inits) {
        this(Alumno_Has_Eventos.class, metadata, inits);
    }

    public QAlumno_Has_Eventos(Class<? extends Alumno_Has_Eventos> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.asignaExamen = inits.isInitialized("asignaExamen") ? new QAsignaExamenEntity(forProperty("asignaExamen")) : null;
        this.primaryKey = inits.isInitialized("primaryKey") ? new QAlumnoEventosId(forProperty("primaryKey"), inits.get("primaryKey")) : null;
    }

}

