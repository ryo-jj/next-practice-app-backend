package com.springboot.test.next_practice_app_backend.controller;

import com.springboot.test.next_practice_app_backend.entity.Tasks;
import com.springboot.test.next_practice_app_backend.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * タスク管理に関する外部からのHTTPリクエストを処理するRESTコントローラー。
 * エンドポイント `/tasks` に対するエンドポイントを提供します。
 * * @author ryo-jj
 * @version 1.0
 */
@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TasksController {

    /** タスク操作のためのリポジトリコンポーネント */
    private final TasksRepository tasksRepository;

    /**
     * データベースに登録されているすべてのタスク一覧を取得します。
     *
     * @return 登録済みの全タスク情報のリスト
     */
    @GetMapping
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    /**
     * 新しいタスクをデータベース（Supabase）に登録します。
     *
     * @param task クライアントから送信されたJSON形式のタスクデータ（リクエストボディ）
     * @return データベースに保存され、IDや作成日時が確定したタスクオブジェクト
     */
    @PostMapping
    public Tasks createVaildTasks(@RequestBody Tasks task) {
        // 現在時刻を確実に生成してセットする
        java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
        task.setCreated_at(now);

        // ログに出力して、本当に値がセットされているかコンソールで確認できるようにする
        System.out.println("保存直前のcreated_atの値: " + task.getCreated_at());

        return tasksRepository.save(task);
    }
}
