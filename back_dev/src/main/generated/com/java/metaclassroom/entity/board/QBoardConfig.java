package com.java.metaclassroom.entity.board;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoardConfig is a Querydsl query type for BoardConfig
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardConfig extends EntityPathBase<BoardConfig> {

    private static final long serialVersionUID = 493966772L;

    public static final QBoardConfig boardConfig = new QBoardConfig("boardConfig");

    public final NumberPath<Long> boardConfigId = createNumber("boardConfigId", Long.class);

    public final EnumPath<com.java.metaclassroom.enums.BoardType> boardType = createEnum("boardType", com.java.metaclassroom.enums.BoardType.class);

    public final EnumPath<com.java.metaclassroom.enums.AnswerYN> isViewUse = createEnum("isViewUse", com.java.metaclassroom.enums.AnswerYN.class);

    public final NumberPath<Integer> topExpoCount = createNumber("topExpoCount", Integer.class);

    public QBoardConfig(String variable) {
        super(BoardConfig.class, forVariable(variable));
    }

    public QBoardConfig(Path<? extends BoardConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoardConfig(PathMetadata metadata) {
        super(BoardConfig.class, metadata);
    }

}

