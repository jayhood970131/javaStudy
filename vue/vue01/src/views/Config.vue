<template>
    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                sortable
                prop="date"
                label="日期"
                width="180"
                :filters="sortData"
                :filter-method="filterHandler">
        </el-table-column>
        <el-table-column
                prop="name"
                label="姓名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="address"
                label="地址">
        </el-table-column>
    </el-table>
</template>

<script>
    export default {
        name: "Config",
        data() {
            return {
                tableData: [{
                        date: '2016-05-02',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                        date: '2016-05-04',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1517 弄'
                    }, {
                        date: '2016-05-01',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1519 弄'
                    }, {
                        date: '2016-05-03',
                        name: '王小虎',
                        address: '上海市普陀区金沙江路 1516 弄'
                    }
                ],
                sortData: [{text: '2016-05-01', value: '2016-05-01'}, {text: '2016-05-02', value: '2016-05-02'}, {text: '2016-05-03', value: '2016-05-03'}, {text: '2016-05-04', value: '2016-05-04'}],

            }
        },
        methods: {
            getData() {
                this.$axios.get('http://localhost:8080/tabelist').then(
                    res => {
                        if (res.data.code == '200') {
                            this.tableData = res.data.result;
                        }
                    },
                    (error) => {

                    }
                )
            },
            filterHandler(value, row, column) {
                const property = column['property'];
                return row[property] === value;
            }
        },
        mounted() {
            this.getData();
        }
    }
</script>

<style scoped>

</style>