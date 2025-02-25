import Profile from "componennts/Profile";
import Header from "componennts/Header";
import Footer from "componennts/Footer";
import PostList from "componennts/PostList";

export default function ProfilePage() {
    return (
        <>
            <Header />
            <Profile />
            <PostList
                hasNavigation={ false }
            />
            <Footer />
        </>
    )
}
