import { Button, Modal, ModalBody, ModalCloseButton, ModalContent, ModalFooter, ModalHeader, ModalOverlay } from '@chakra-ui/react'
import React from 'react'
import { BsThreeDots } from 'react-icons/bs'

const CommentModel = ({onClose, isOpen}) => {
  return (
    <div>
        <Modal size={"4xl"} onClose={onClose} isOpen={true} isCentered>
        <ModalOverlay />
        <ModalContent>
          <ModalBody>
          <div className='flex h-[75vh]'>
            <div className='w-[45%] flex flex-col justify-center'>
                <img className='max-h-full w-full' src='https://cdn.pixabay.com/photo/2023/03/28/01/10/money-7881948__340.jpg' alt='' />
            </div>
            <div className='w-[55%] pl-10'> 
                <div className='flex justify-between items-center py-5'>
                    <div className='flex items-center'>
                    <div>
                        <img className='w-9 h-9 rounded-full' src='https://cdn.pixabay.com/photo/2022/06/16/13/02/dog-7265934__340.jpg' alt='' />
                    </div>
                    <div className='ml-2'>
                        <p>username</p>
                    </div>
                </div>
                    <BsThreeDots />
                </div>                    
            </div>
          </div>
          </ModalBody>
        </ModalContent>
      </Modal>
    </div>
  )
}

export default CommentModel