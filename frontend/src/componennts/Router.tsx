import { useState } from "react";

import React from 'react';
import { Route, Routes, Navigate } from 'react-router-dom';
import Home from "pages/home";
import PostList from "pages/posts";
import PostPage from "pages/posts/detail";
import PostNew from "pages/posts/new";
import PostEdit from "pages/posts/edit";
import ProfilePage from "pages/profile";
import LoginPage from "pages/login";
import SignupPage from "pages/signup";


export default function Router() {
    // 스프링부트에서 Auth가 인증되었으면 true로 변경
    const [isAuthenticated, setIsAuthenticated] = useState<boolean>(false);

    return (
        <>
            <Routes>
                {isAuthenticated ? (
                    <>
                        <Route path="/" element={<Home />}/>
                        <Route path="/posts" element={<PostList />}/>
                        <Route path="/posts/:id" element={<PostPage />}/>
                        <Route path="/posts/new" element={<PostNew />} />
                        <Route path="/posts/edit/:id" element={<PostEdit />} />
                        <Route path="/profile" element={<ProfilePage />} />
                        <Route path="/login" element={<LoginPage />}/>
                        <Route path="/signup" element={<SignupPage />}/>
                        {/* 우리가 정의한 url 이외의 url은 강제 홈 페이지로 리다이렉션 */}
                        <Route path="*" element={<Navigate to="/" />} />
                    </>
                ) : (
                    <>
                        <Route path="/login" element={<LoginPage />}/>
                        <Route path="/signup" element={<SignupPage />}/>
                        <Route path="*" element={<LoginPage />} />
                    </>
                )}
            </Routes>
        </>
    )
}

