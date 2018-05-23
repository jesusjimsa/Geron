//
//  ChooseNewDevice.swift
//  Geco
//
//  Created by Jesús Jiménez Sánchez on 23/5/18.
//  Copyright © 2018 Jesús Jiménez Sánchez. All rights reserved.
//

import Cocoa

class ChooseNewDevice: NSViewController {
	
	@IBAction func dismiss(_ sender: Any) {
		self.dismissViewController(self)
	}
	
	required init(coder: NSCoder){
		super.init(coder: coder)!
	}
}
