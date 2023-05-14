package com.randomuser.data.mapper

import com.randomuser.data.database.UserDbModel
import com.randomuser.data.model.User
import com.randomuser.domain.UserDomain

object UserMapper {

    fun mapUserResponseToUser(userResponse: User) = UserDomain(
        firstName = userResponse.name.first,
        lastName = userResponse.name.last,
        picture = userResponse.picture.large
    )

    fun mapEntityToDbModel(userDomain: UserDomain) = UserDbModel(
        id = 0,
        firstName = userDomain.firstName,
        lastName = userDomain.lastName,
        picture = userDomain.picture
    )

    fun mapDbModelToEntity(userDbModel: UserDbModel) = UserDomain(
        firstName = userDbModel.firstName,
        lastName = userDbModel.lastName,
        picture = userDbModel.picture
    )

    fun mapListDbModelToListEntity(list: List<UserDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}