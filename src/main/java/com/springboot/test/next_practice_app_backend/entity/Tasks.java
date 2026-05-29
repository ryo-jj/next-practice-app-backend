package com.springboot.test.next_practice_app_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * タスク情報を管理する永続化エンティティクラス。
 * Supabaseの「tasks」テーブルと1対1でマッピングされます。
 * * @author ryo-jj
 * @version 1.0
 */
@Entity
@Table(name = "tasks")
@Data
public class Tasks {

    /** タスクを一意に識別する主キー（UUID形式） */
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    /** タスクのタイトル */
    @Column
    private String title;

    /** タスクの分類 */
    @Column
    private String[] type;

    /** タスクの詳細説明 */
    @Column
    private String description;

    /** タスクのステータス */
    @Column
    private String status;

    /** レコードの作成日時 */
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp created_at;

    /** タスクを所有するユーザーの識別ID */
    @Column
    private String user_id;

    /** タスクの期限日 */
    @Column
    private Date period;

}
