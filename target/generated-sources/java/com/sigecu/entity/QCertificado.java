package com.sigecu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCertificado is a Querydsl query type for Certificado
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCertificado extends EntityPathBase<Certificado> {

    private static final long serialVersionUID = 312892833L;

    public static final QCertificado certificado = new QCertificado("certificado");

    public final StringPath alumno = createString("alumno");

    public final NumberPath<Float> califiacion = createNumber("califiacion", Float.class);

    public final StringPath curso = createString("curso");

    public final StringPath fecha = createString("fecha");

    public final NumberPath<Integer> idCertificado = createNumber("idCertificado", Integer.class);

    public QCertificado(String variable) {
        super(Certificado.class, forVariable(variable));
    }

    public QCertificado(Path<? extends Certificado> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCertificado(PathMetadata metadata) {
        super(Certificado.class, metadata);
    }

}

