package com.ims.imsandroid.db.dao

import androidx.room.*
import com.ims.imsandroid.db.bean.User

/**
 *
 * @ProjectName:    compose
 * @Package:        com.ims.compose.db.dao
 * @ClassName:      UserDao
 * @Description:     用户查询
 * @Author:         Jsiony
 * @CreateDate:     2022/11/2 15:50
 * @UpdateUser:     更新者
 * @UpdateDate:     2022/11/2 15:50
 * @UpdateRemark:   更新说明
 * @Version:        1.0.0
 */
@Dao
interface UserDao : BaseDAO<User> {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE ACCOUNT LIKE :first AND " +
            "ACCOUNT LIKE :last ORDER BY ACCOUNT DESC LIMIT 1")
    fun findByName(first: String, last: String): User

    // onConflict 配置主键冲突处理
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User)

    @Insert
    fun insertBothUsers(user1: User, user2: User)

    @Insert
    fun insertUsersAndFriends(user: User, friends: List<User>)

    @Delete
    override suspend fun delete(obj: User)
}