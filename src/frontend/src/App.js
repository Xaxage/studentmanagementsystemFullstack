import React, {Component} from 'react';
import Container from "./container";
import './App.css';
import {getAllStudents} from "./client"
import {Avatar, Table, Spin } from "antd";
import { LoadingOutlined } from '@ant-design/icons';

const getAntIndicator = () => <LoadingOutlined style={{ fontSize: 24 }} spin />;


class App extends Component {

    state = {
        students: [],
        isFetching: false
    }

    componentDidMount() {
        this.fetchStudents();
    }

    fetchStudents = () => {
        this.setState({
            isFetching: true
        });
        getAllStudents()
            .then(res => res.json()
                .then(students => {
                    console.log(students);
                    this.setState({
                        students,
                        isFetching: false
                    });
                }))
    }

    render() {



        const {students, isFetching} = this.state;

        if(isFetching){
            return (
                <Container>
                    <Spin indicator={getAntIndicator()} size="large"/>
                </Container>
            );
        }

        if (students && students.length) {

            const columns = [

                {
                    title: "",
                    key: "avatar",
                    render: (text, student) => (
                        <Avatar size={"large"}>
                            {`
                            ${student.firstName.charAt(0).toUpperCase()}
                            ${student.lastName.charAt(0).toUpperCase()}
                            `}
                        </Avatar>
                    )
                },

                {
                    title: "Student Id",
                    dataIndex: "studentId",
                    key: "studentId"
                },
                {
                    title: "First Name",
                    dataIndex: "firstName",
                    key: "firstName"
                },
                {
                    title: "Last Name",
                    dataIndex: "lastName",
                    key: "lastName"
                },
                {
                    title: "Email",
                    dataIndex: "email",
                    key: "email"
                },
                {
                    title: "Gender",
                    dataIndex: "gender",
                    key: "gender"
                }
            ]

            return (
                <Container>
                    <Table
                        dataSource={students}
                        columns={columns}
                        pagination={false}
                        rowKey="studentId"/>
                </Container>
            );

        }

        return (
            <h1>No Students Found</h1>
        );
    }
}

export default App;
