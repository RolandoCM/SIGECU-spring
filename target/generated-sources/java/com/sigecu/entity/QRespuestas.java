package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRespuestas is a Querydsl query type for Respuestas
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRespuestas extends EntityPathBase<Respuestas> {

    private static final long serialVersionUID = 308736195L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRespuestas respuestas = new QRespuestas("respuestas");

    public final NumberPath<Integer> idRespuesta = createNumber("idRespuesta", Integer.class);

    public final QPreguntas preguntas;

    public final StringPath rRespuesta = createString("rRespuesta");

    public final StringPath rSolucion = createString("rSolucion");

    public QRespuestas(String variable) {
        this(Respuestas.class, forVariable(variable), INITS);
    }

    public QRespuestas(Path<? extends Respuestas> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRespuestas(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRespuestas(PathMetadata metadata, PathInits inits) {
        this(Respuestas.class, metadata, inits);
    }

    public QRespuestas(Class<? extends Respuestas> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.preguntas = inits.isInitialized("preguntas") ? new QPreguntas(forProperty("preguntas"), inits.get("preguntas")) : null;
    }

}

