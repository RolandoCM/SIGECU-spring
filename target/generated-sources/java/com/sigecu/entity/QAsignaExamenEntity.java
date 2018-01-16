package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAsignaExamenEntity is a Querydsl query type for AsignaExamenEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAsignaExamenEntity extends EntityPathBase<AsignaExamenEntity> {

    private static final long serialVersionUID = -1954607810L;

    public static final QAsignaExamenEntity asignaExamenEntity = new QAsignaExamenEntity("asignaExamenEntity");

    public final SetPath<Alumno_Has_Eventos, QAlumno_Has_Eventos> alumnoHasEventos = this.<Alumno_Has_Eventos, QAlumno_Has_Eventos>createSet("alumnoHasEventos", Alumno_Has_Eventos.class, QAlumno_Has_Eventos.class, PathInits.DIRECT2);

    public final StringPath asignado = createString("asignado");

    public final StringPath fechaFin = createString("fechaFin");

    public final StringPath fechaInicio = createString("fechaInicio");

    public final StringPath horafin = createString("horafin");

    public final StringPath horaInicio = createString("horaInicio");

    public final NumberPath<Integer> idasignaExamen = createNumber("idasignaExamen", Integer.class);

    public final StringPath realizado = createString("realizado");

    public final SetPath<RespuestaALMEntity, QRespuestaALMEntity> respuestasAML = this.<RespuestaALMEntity, QRespuestaALMEntity>createSet("respuestasAML", RespuestaALMEntity.class, QRespuestaALMEntity.class, PathInits.DIRECT2);

    public final StringPath status = createString("status");

    public QAsignaExamenEntity(String variable) {
        super(AsignaExamenEntity.class, forVariable(variable));
    }

    public QAsignaExamenEntity(Path<? extends AsignaExamenEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAsignaExamenEntity(PathMetadata metadata) {
        super(AsignaExamenEntity.class, metadata);
    }

}

