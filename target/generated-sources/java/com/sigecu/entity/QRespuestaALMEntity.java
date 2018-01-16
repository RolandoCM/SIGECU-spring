package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRespuestaALMEntity is a Querydsl query type for RespuestaALMEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRespuestaALMEntity extends EntityPathBase<RespuestaALMEntity> {

    private static final long serialVersionUID = -1420442539L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRespuestaALMEntity respuestaALMEntity = new QRespuestaALMEntity("respuestaALMEntity");

    public final QAsignaExamenEntity asignaExamen;

    public final NumberPath<Integer> idPregunta = createNumber("idPregunta", Integer.class);

    public final NumberPath<Integer> idRespuesta = createNumber("idRespuesta", Integer.class);

    public final NumberPath<Integer> idRespuestaALM = createNumber("idRespuestaALM", Integer.class);

    public final StringPath seleccionada = createString("seleccionada");

    public QRespuestaALMEntity(String variable) {
        this(RespuestaALMEntity.class, forVariable(variable), INITS);
    }

    public QRespuestaALMEntity(Path<? extends RespuestaALMEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRespuestaALMEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRespuestaALMEntity(PathMetadata metadata, PathInits inits) {
        this(RespuestaALMEntity.class, metadata, inits);
    }

    public QRespuestaALMEntity(Class<? extends RespuestaALMEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.asignaExamen = inits.isInitialized("asignaExamen") ? new QAsignaExamenEntity(forProperty("asignaExamen")) : null;
    }

}

