package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreguntas is a Querydsl query type for Preguntas
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPreguntas extends EntityPathBase<Preguntas> {

    private static final long serialVersionUID = 298413241L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreguntas preguntas = new QPreguntas("preguntas");

    public final QEvaluaciones evaluaciones;

    public final NumberPath<Integer> idPregunta = createNumber("idPregunta", Integer.class);

    public final StringPath pDescripcion = createString("pDescripcion");

    public final StringPath pPregunta = createString("pPregunta");

    public final StringPath pPuntaje = createString("pPuntaje");

    public final SetPath<Respuestas, QRespuestas> respuestas = this.<Respuestas, QRespuestas>createSet("respuestas", Respuestas.class, QRespuestas.class, PathInits.DIRECT2);

    public QPreguntas(String variable) {
        this(Preguntas.class, forVariable(variable), INITS);
    }

    public QPreguntas(Path<? extends Preguntas> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreguntas(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreguntas(PathMetadata metadata, PathInits inits) {
        this(Preguntas.class, metadata, inits);
    }

    public QPreguntas(Class<? extends Preguntas> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.evaluaciones = inits.isInitialized("evaluaciones") ? new QEvaluaciones(forProperty("evaluaciones"), inits.get("evaluaciones")) : null;
    }

}

