import React, {useState} from 'react'
import { IoReorderThreeOutline } from "react-icons/io5"
import { mainu } from './SidebarConfig'
import { useNavigate } from 'react-router-dom';
const Sidebar = () => {
  const [activeTab, setActiveTab] = useState("");
  const navigate = useNavigate();
  const { isOpen, onOpen, onClose } = useDisclosure();
  const [isSearchVisible, setIsSearchVisible] = useState(false);

    const handleTabClick = (title) => {
        setActiveTab(title);
        if (title === "Profile") {
            navigate("/username");
        } else if (title === "Home") {
            navigate("/");
      }
        else if (title === "Home"){
          navigate("/");
      }
        else if (title === "Create") {
          onOpen();
      }
      if (title === "Search") {
        setIsSearchVisible(true)
      }
      else setIsSearchVisible(false)
    };
    

  return (
    <div className='sticky top-0 h-[100vh] flex'>
          <div className={`flex flex-col justify-between h-full ${activeTab==="Search"?"px-2":"px-10"}`}>
              {<div>
                  

              <div className='mt-10'>
                  {mainu.map((item) => (
                  <div onClick={()=>handleTabClick(item.title)} className='flex items-center mb-5 cursor-pointer text-lg'>
                    {activeTab===item.title? item.activeIcon:item.icon}    
                      {activeTab !== "Search" && <p className={`${activeTab===item.title?"font-bold":"font-semibold"}`}>{ item.title }</p>}                      
                  </div>
                  ))}                  
                </div>
              </div>}
              <div className='flex items-center cursor-pointer pb-10'> 
              <IoReorderThreeOutline className="text-2xl" />
              {activeTab !== "Search" && <p className='ml-5'>More</p>}
          </div>
      </div>
      <CreatePostModel onClose={onClose} isOpen={isOpen} />
      {isSearchVisible && <SearchComponents />}
      </div>
      
  )
}

export default Sidebar