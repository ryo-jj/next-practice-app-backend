package com.springboot.test.next_practice_app_backend.repository;

import com.springboot.test.next_practice_app_backend.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * tasksテーブルへのデータベースアクセスを担当するリポジトリインターフェース。
 * JpaRepositoryを継承することで、基本的なCRUD操作（保存・検索・削除等）のメソッドが自動提供されます。
 * * @see org.springframework.data.jpa.repository.JpaRepository
 * @author ryo-jj
 * @version 1.0
 */
@Repository
public interface TasksRepository extends JpaRepository<Tasks, UUID> {
    // 独自のクエリ（メソッド）を追加する場合は、ここにJavaDocと共に追記します
}
