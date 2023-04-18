import React, { useState } from 'react'
import { BsThreeDots, BsBookmarkFill, BsBookmark, BsEmojiSmile } from 'react-icons/bs'
import "./PostCard.css"
import { AiFillHeart, AiOutlineHeart } from 'react-icons/ai'
import { FaRegComment } from 'react-icons/fa'
import {RiSendPlaneLine} from 'react-icons/ri'
import CommentModel from '../Comment/CommentModel'

const PostCard = () => {
    const [showDropDown, setShowDropDown] = useState(false);
    const [isPostLiked, setIsPostLiked] = useState(false);
    const [isSaved, setIsSaved] = useState(false);

    const handleSavePost = () => {
        setIsSaved(!isSaved);
    }

    const handlePostLike = () => {
        setIsPostLiked(!isPostLiked);
    }
    const handleClick = () => {
        setShowDropDown(!showDropDown);
    }

  return (
    <div>
        <div className='border rounded-md w-full'>
            <div className='flex justify-between items-center w-full py-4 px-5'> 
                <div className='flex items-center'>
                      <img className='h-12 w-12 rounded-full' src='https://cdn.pixabay.com/photo/2023/03/29/17/05/artisanal-food-7885997__340.jpg' alt='' />
                      <div className='pl-2'>
                          <p className='font-semibold text-sm'>username</p>
                          <p className='font-thin text-sm'>location</p>
                      </div>
                </div>
                
                  <div className='dropdown'>
                      <BsThreeDots className="dots" onClick={handleClick} />
                      <div  className='dropdown-content'>
                          { showDropDown && <p className='bg-black text-white py-1 px-4 rounded-md cursor-pointer'>Delete</p>}
                      </div>
                  </div>
                  
                  

              </div>
              
            <div className='w-full'>
                    <img src='https://cdn.pixabay.com/photo/2023/03/28/09/28/cat-7882701__340.jpg' alt='' />
            </div>

              <div className='flex justify-between items-center w-full px-5 py-4'>
                  <div className='flex items-center space-x-2'>
                      {isPostLiked? <AiFillHeart className="text-2xl hover:opacity-50 cursor-pointer text-red-600"  onClick={handlePostLike} />:<AiOutlineHeart className="text-2xl hover:opacity-50 cursor-pointer"  onClick={handlePostLike} />}
                      <FaRegComment className="text-xl hover:opacity-50 cursor-pointer" />
                      <RiSendPlaneLine className="text-xl hover:opacity-50 cursor-pointer" />
                  </div>

                  <div className='cursor-pointer'>
                      {isSaved?<BsBookmarkFill onClick={handleSavePost} className="text-xl hover:opacity-50 cursor-pointer" />:<BsBookmark onClick={handleSavePost} className="text-xl hover:opacity-50 cursor-pointer" />}
                  </div>

              </div>

              <div className='w-full py-2 px-5'>
                  <p>10 Likes</p>
                  <p className='opacity-50 py-2 cursor-pointer'>View all 10 comments</p>
              </div>

              <div className='border border-t w-full'>
                  <div className='flex w-full items-center px-5'>
                      <BsEmojiSmile />
                      <input className='commentInput' type='text' placeholder='Add a comment...' />
                  </div>
              </div>
          </div>
          
          <CommentModel />
    </div>
  )
}

export default PostCard