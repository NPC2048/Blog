<template>
    <div slot="header">
        <el-row justify="center">
            <router-link to="/login">
                <el-button type="text">
                    登录
                </el-button>
            </router-link>
            <el-divider direction="vertical"/>
            <router-link to="/register">
                <el-button type="text">
                    注册
                </el-button>
            </router-link>
        </el-row>
        <el-divider/>
    </div>
</template>
<style scoped>
</style>